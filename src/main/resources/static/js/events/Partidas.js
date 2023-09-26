import Alert from "../Components/Alert.js";

export const resetform = (urlServer, e) => {
  const form = document.querySelector("#form-partidas");
  if (form) {
    form.reset();
  }
};

export const getAllPartidas = (urlServer, e) => {
  e.preventDefault();
  const url = `${urlServer}/partidas/`;
  fetch(url)
  .then(res => res.ok ? res.json(): Promise.reject(res))
    .then((res) => {
      if (res.success) {
        let data = JSON.parse(res.data);
        let tbody = document.querySelector("#tbody-partidas");
        if (tbody !== null) {
          tbody.innerHTML = "";
          data.forEach((partida) => {
            tbody.innerHTML += `
          <tr>
            <td>${partida.fecha_partida}</td>
            <td>Partida #${partida.id_partida}</td>
            <td>${partida.descripcion_partida}</td>
            <td>
              <a href="./libro-diario.html?id=${partida.id_partida}" class="btn btn-sm btn-warning"><i class="fas fa-pen"></i></a>
              <a data-id="${partida.id_partida}" class="btn btn-sm btn-danger"><i class="fas fa-trash"></i></a>
            </td>
          </tr>
          `;
          });
        }
      }
    });
};

export const nuevaPartida = (urlServer, e) => {
  e.preventDefault();
  const form = document.querySelector("#form-partidas");
  let data = new FormData(form);
  data = JSON.stringify({
    fecha_partida: data.get("fecha_partida"),
    descripcion_partida: data.get("descripcion_partida"),
  });
  const url = `${urlServer}/partidas/new`;
  fetch(url, {
    method: "POST",
    body: data,
    headers: {
      "Content-Type": "application/json",
    },
  })
  .then(res => res.ok ? res.json(): Promise.reject(res))
    .then((res) => {
      if (res.success) {
        form.reset();
        let data = JSON.parse(res.data);
        Alert(
          "Success",
          `Partida #${data.id_partida} creada exitosamente`,
          "success"
        );
        window.location.href = `./libro-diario.html?id=${data.id_partida}`;
      } else {
        Alert("Error", res.message, "error");
      }
    })
    .catch((err) => console.log(err));
};

export const deletePartida = (urlServer, e) => {
  if (
    e.target.matches("#tbody-partidas a[data-id]") ||
    e.target.matches("#tbody-partidas a[data-id] *")
  ) {
    const id = e.target.dataset.id || e.target.parentElement.dataset.id;
    Alert.confirm(
      `¿Desea eliminar esta partida #${id} de forma permanente?`,
      { si: "Eliminar", no: "Cancelar" },
      () => {
        const url = `${urlServer}/partidas/delete`;
        fetch(url, {
          method: "DELETE",
          body: id,
        })
          .then(res => res.ok ? res.json(): Promise.reject(res))
          .then((res) => {
            if (res.success) {
              Alert(
                "Success",
                `La partida #${res.data} fue borrara exitosamente`,
                "success"
              );
              getAllPartidas(urlServer, e);
            } else {
              Alert("Error", res.message, "error");
            }
          })
          .catch((err) => console.log(err));
      },
      "info"
    );
  }
};

const Params = () => {
  let a = location.search,
    size = 0;
  a = a.substr(1, a.length).replace(/[?&=]/g, ":").split(":");
  const b = {};
  for (let i = 0; i < a.length - 1; i++) {
    b[a[i]] = a[i + 1];
    i++;
    size++;
  }
  return { ...b, size };
};

export const loaderDetallePartida = (url, e) => {
  const tableBody = document.getElementById("table-body");
  const entryForm = document.getElementById("entry-form");
  const editEntryButton = document.getElementById("edit-entry");
  const updateEntryButton = document.getElementById("update-entry");
  const deleteEntryButton = document.getElementById("delete-entry");
  const deleteAllButton = document.getElementById("delete-all");
  const exitButton = document.getElementById("exit");
  const fechaInput = document.getElementById("fecha");
  const subcuentaInput = document.getElementById("cuenta");
  const descripcionInput = document.getElementById("descripcion");
  const tipoInput = document.getElementById("tipo");
  const montoInput = document.getElementById("monto");
  let selectedRowIndex = -1;
  const id_partida = Params().id;
  let subcuentas = [];

  // Función para cargar datos en la tabla
  function loadTableData(data) {
    tableBody.innerHTML = "";
    let haberes = 0,
      debes = 0;
    data
      .sort((a, b) =>
        b.descripcion.toLowerCase().localeCompare(a.descripcion.toLowerCase())
      )
      .forEach((entry, index) => {
        const newRow = document.createElement("tr");
        newRow.id = entry.id_detalle_partida;
        let subcuenta = subcuentas.find(
          (el) => el.id_subcuentas === entry.fk_subcuentas
        );
        newRow.innerHTML = `
                <td data-fecha><span>${entry.fecha}</span></td>
                <td data-description><span>${entry.descripcion}</span></td>
                <td data-el="${entry.fk_subcuentas}">
                  ${
                    entry.tipo !== "DEBE"
                      ? "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
                      : ""
                  }
                  ${subcuenta.codigo_subcuentas} - 
                  ${subcuenta.nombre_subcuentas}
                </td>
                <td>${entry.tipo === "DEBE" ? entry.monto.toFixed(2) : ""}</td>
                <td>${entry.tipo !== "DEBE" ? entry.monto.toFixed(2) : ""}</td>
            `;
        newRow.addEventListener("click", () => selectRow(index));
        tableBody.appendChild(newRow);
        if (entry.tipo === "DEBE") {
          debes += parseFloat(entry.monto);
        } else {
          haberes += parseFloat(entry.monto);
        }
      });

    let totales = document.createElement("tr");
    totales.innerHTML = `
    <td colspan="3"><strong>Total<strong></td>
    <td><strong>${debes.toFixed(2)}<strong></td>
    <td><strong>${haberes.toFixed(2)}<strong></td>
    `;
    tableBody.appendChild(totales);

    let tds = tableBody.querySelectorAll("tr");
    for (let i = 0; i < tds.length; i++) {
      if (tds[i + 1]) {
        let el1 = tds[i],
          el2 = tds[i + 1];
        if (el2.querySelector("td[data-description] span") !== null) {
          if (
            el1.querySelector("td[data-fecha] span").innerHTML.toLowerCase() ==
              el2
                .querySelector("td[data-fecha] span")
                .innerHTML.toLowerCase() &&
            el1
              .querySelector("td[data-description] span")
              .innerHTML.toLowerCase() ==
              el2
                .querySelector("td[data-description] span")
                .innerHTML.toLowerCase()
          ) {
            if (el2.querySelector("td[data-fecha] span")) {
              el2.querySelector("td[data-fecha] span").style.visibility =
                "hidden";
              el2.querySelector("td[data-description] span").style.visibility =
                "hidden";
            }
          }
        }
      }
    }
  }

  // Datos iniciales
  const initialData = [];

  const getAll = () => {
    fetch(`${url}/partidas/${id_partida}/detalles`)
      .then(res => res.ok ? res.json(): Promise.reject(res))
      .then((res) => {
        if (res.success) {
          const data = JSON.parse(res.data);
          subcuentas = JSON.parse(res.cuentas);
          data.forEach((entry) => {
            initialData.push(entry);
          });
          loadTableData(initialData);
        }else {
          console.log(err);
          Alert("Error", "No se pudo cargar los apuntes", "error");
        }
      })
      .catch((err) => {
        console.log(err);
        Alert("Error", "No se pudo cargar los apuntes", "error");
      });
  };

  if(tableBody){
  getAll();
  }

  // Evento para agregar nuevo apunte
  if (entryForm) {
    entryForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const fecha = fechaInput.value;
      const subcuenta = subcuentaInput.value;
      const descripcion = descripcionInput.value;
      const tipo = tipoInput.value;
      const monto = parseFloat(montoInput.value) || 0;

      if (selectedRowIndex === -1) {
        // Agregar nuevo apunte
        fetch(`${url}/partidas/${id_partida}/detalles/new`, {
          method: "POST",
          body: JSON.stringify({
            fk_partida: id_partida,
            fecha,
            fk_subcuentas: subcuenta,
            descripcion,
            tipo,
            monto,
          }),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then(res => res.ok ? res.json(): Promise.reject(res))
          .then((res) => {
            if (res.success) {
              const newRow = document.createElement("tr");
              const data = JSON.parse(res.data);
              initialData.push(data);
              loadTableData(initialData);
              entryForm.reset(); // Limpiar el formulario
              $("#cuenta").data("selectize").setValue("");
              fechaInput.value = new Date().toISOString().split("T")[0];
              Alert("Success", "Apunte agregado exitosamente", "success");
            }else {
              console.log(err);
              Alert("Error", "No se pudo agregar el apunte", "error");
            }
          })
          .catch((err) => {
            console.log(err);
            Alert("Error", "No se pudo agregar el apunte", "error");
          });
      } else {
        // Actualizar apunte existente
        const updatedRow = tableBody.children[selectedRowIndex];
        const [fechaCell, descripcionCell, subcuentaCell, debeCell, haberCell] =
          updatedRow.children;
        fechaCell.textContent = fecha;
        subcuentaCell.textContent = subcuentaInput.querySelector(
          `option[value="${subcuenta}"]`
        ).innerHTML;
        subcuentaCell.dataset.el = subcuenta;
        descripcionCell.textContent = descripcion;
        debeCell.textContent = tipo === "DEBE" ? monto.toFixed(2) : "";
        haberCell.textContent = tipo !== "DEBE" ? monto.toFixed(2) : "";

        fetch(`${url}/partidas/${id_partida}/detalle/${initialData[selectedRowIndex].id_detalle_partida}/edit`, {
          method: "PUT",
          body: JSON.stringify({
            fk_partida: id_partida,
            fecha,
            fk_subcuentas: subcuenta,
            descripcion,
            tipo,
            monto,
          }),
          headers: {
            "Content-Type": "application/json",
          },
        }).then(res => res.ok ? res.json(): Promise.reject(res))
        .then((res) => {
          console.log(res);
          if (res.success) {
            initialData[selectedRowIndex] = JSON.parse(res.data);
            loadTableData(initialData);
            selectedRowIndex = -1; // Resetear el índice seleccionado
            entryForm.reset(); // Limpiar el formulario
            $("#cuenta").data("selectize").setValue("");
            fechaInput.value = new Date().toISOString().split("T")[0];
            entryForm.querySelector("button[type=submit]").textContent =
              "Agregar Apunte";
            Alert("Success", "Apunte editado exitosamente", "success");
          }else {
            console.log(err);
            Alert("Error", "No se pudo editar el apunte", "error");
          }
        })
        .catch((err) => {
          console.log(err);
          Alert("Error", "No se pudo editar el apunte", "error");
        });
      }
    });

    // Evento para reset form
    editEntryButton.addEventListener("click", function () {
      if (selectedRowIndex !== -1) {
        // Habilitar la edición del apunte seleccionado
        entryForm.reset(); // Limpiar el formulario
        $("#cuenta").data("selectize").setValue("");
        fechaInput.value = new Date().toISOString().split("T")[0];
        selectedRowIndex = -1; // Resetear el índice seleccionado
        entryForm.querySelector("button[type=submit]").textContent =
          "Agregar Apunte";
      }
    });

    // Evento para borrar apunte
    deleteEntryButton.addEventListener("click", function () {
      if (selectedRowIndex !== -1) {
        // Eliminar el apunte seleccionado
        tableBody.removeChild(tableBody.children[selectedRowIndex]);
        initialData.splice(selectedRowIndex, 1);
        selectedRowIndex = -1; // Resetear el índice seleccionado
        entryForm.reset(); // Limpiar el formulario
        $("#cuenta").data("selectize").setValue("");
        fechaInput.value = new Date().toISOString().split("T")[0];
      }
    });

    // Evento para borrar asiento completo
    deleteAllButton.addEventListener("click", function () {
      Alert.confirm(
        `¿Desea eliminar todos los asientos de la  partida #${id_partida} de forma permanente?`,
        { si: "Eliminar", no: "Cancelar" },
        () => {
            fetch(`${url}/partidas/${id_partida}/detalle/delete-all`,{
                method: "DELETE",
                body:id_partida,
                headers: {
                  "Content-Type": "application/json",
                },
              }
            )
            .then(res => res.ok ? res.json() : Promise.reject(res))
            .then(data => {
              if(data.success){
                tableBody.innerHTML = ""; // Borrar todas las filas
                initialData.length = 0; // Limpiar los datos
                selectedRowIndex = -1; // Resetear el índice seleccionado
                entryForm.reset(); // Limpiar el formulario
                $("#cuenta").data("selectize").setValue("");
                fechaInput.value = new Date().toISOString().split("T")[0];
                Alert('Success', 'Asientos eliminados correctamente.', 'success');
              }else {
                console.log(err);
                Alert("Error", "No se pudo borrar todos los apuntes", "error");
              }
            })
            .catch((err) => {
              console.log(err);
              Alert("Error", "No se pudo borrar todos los apuntes", "error");
            });
          });
    });
  }

  // Función para seleccionar una fila en la tabla
  function selectRow(index) {
    selectedRowIndex = index;
    const selectedRow = tableBody.children[index];
    const [fecha, descripcion, subcuenta, debe, haber] = selectedRow.children;
    fechaInput.value = fecha.textContent;
    subcuentaInput.value = subcuenta.dataset.el;
    $("#cuenta").data("selectize").setValue(subcuenta.dataset.el);
    descripcionInput.value = descripcion.textContent;
    tipoInput.value = debe.textContent > 0 ? "DEBE" : "HABER";
    montoInput.value =
      debe.textContent > 0 ? debe.textContent : haber.textContent;
    entryForm.querySelector("button[type=submit]").textContent =
      "Actualizar Apunte";
  }
};
