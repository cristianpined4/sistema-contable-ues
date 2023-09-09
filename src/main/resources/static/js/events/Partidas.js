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
    .then((res) => res.json())
    .then((res) => {
      if (res.success) {
        let data = JSON.parse(res.data);
        let tbody = document.querySelector("#tbody-partidas");
        tbody.innerHTML = "";
        data.forEach((partida) => {
          tbody.innerHTML += `
          <tr>
            <td>${partida.fecha_partida}</td>
            <td>Partida #${partida.id_partida}</td>
            <td>${partida.descripcion_partida}</td>
            <td>
              <a href="#" class="btn btn-sm btn-warning"><i class="fas fa-pen"></i></a>
              <a data-id="${partida.id_partida}" class="btn btn-sm btn-danger"><i class="fas fa-trash"></i></a>
            </td>
          </tr>
          `;
        });
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
    .then((res) => res.json())
    .then((res) => {
      if (res.success) {
        form.reset();
        let data = JSON.parse(res.data);
        Alert(
          "Success",
          `Partida #${data.id_partida} creada exitosamente`,
          "success"
        );
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
          .then((res) => res.json())
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
