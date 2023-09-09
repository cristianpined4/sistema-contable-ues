document.addEventListener("DOMContentLoaded", function () {
  const tableBody = document.getElementById("table-body");
  const entryForm = document.getElementById("entry-form");
  const editEntryButton = document.getElementById("edit-entry");
  const updateEntryButton = document.getElementById("update-entry");
  const deleteEntryButton = document.getElementById("delete-entry");
  const deleteAllButton = document.getElementById("delete-all");
  const exitButton = document.getElementById("exit");
  const fechaInput = document.getElementById("fecha");
  const cuentaInput = document.getElementById("cuenta");
  const descripcionInput = document.getElementById("descripcion");
  const debeInput = document.getElementById("debe");
  const haberInput = document.getElementById("haber");
  let selectedRowIndex = -1;

  // Función para cargar datos en la tabla
  function loadTableData(data) {
    tableBody.innerHTML = "";
    data.forEach((entry, index) => {
      const newRow = document.createElement("tr");
      newRow.innerHTML = `
                <td>${entry.fecha}</td>
                <td>${entry.cuenta}</td>
                <td>${entry.descripcion}</td>
                <td>${entry.debe.toFixed(2)}</td>
                <td>${entry.haber.toFixed(2)}</td>
            `;
      newRow.addEventListener("click", () => selectRow(index));
      tableBody.appendChild(newRow);
    });
  }

  // Datos iniciales
  const initialData = [];

  // Cargar datos iniciales en la tabla
  loadTableData(initialData);

  // Evento para agregar nuevo apunte
  entryForm.addEventListener("submit", function (e) {
    e.preventDefault();
    const fecha = fechaInput.value;
    const cuenta = cuentaInput.value;
    const descripcion = descripcionInput.value;
    const debe = parseFloat(debeInput.value) || 0;
    const haber = parseFloat(haberInput.value) || 0;

    if (selectedRowIndex === -1) {
      // Agregar nuevo apunte
      const newRow = document.createElement("tr");
      newRow.innerHTML = `
                <td>${fecha}</td>
                <td>${cuenta}</td>
                <td>${descripcion}</td>
                <td>${debe.toFixed(2)}</td>
                <td>${haber.toFixed(2)}</td>
            `;
      newRow.addEventListener("click", () => selectRow(initialData.length));
      tableBody.appendChild(newRow);
      initialData.push({ fecha, cuenta, descripcion, debe, haber });
    } else {
      // Actualizar apunte existente
      const updatedRow = tableBody.children[selectedRowIndex];
      const [fechaCell, cuentaCell, descripcionCell, debeCell, haberCell] =
        updatedRow.children;
      fechaCell.textContent = fecha;
      cuentaCell.textContent = cuenta;
      descripcionCell.textContent = descripcion;
      debeCell.textContent = debe.toFixed(2);
      haberCell.textContent = haber.toFixed(2);
      initialData[selectedRowIndex] = {
        fecha,
        cuenta,
        descripcion,
        debe,
        haber,
      };
      selectedRowIndex = -1; // Resetear el índice seleccionado
      entryForm.reset(); // Limpiar el formulario
    }
  });

  // Función para seleccionar una fila en la tabla
  function selectRow(index) {
    selectedRowIndex = index;
    const selectedRow = tableBody.children[index];
    const [fecha, cuenta, descripcion, debe, haber] = selectedRow.children;
    fechaInput.value = fecha.textContent;
    cuentaInput.value = cuenta.textContent;
    descripcionInput.value = descripcion.textContent;
    debeInput.value = debe.textContent;
    haberInput.value = haber.textContent;
  }

  // Evento para editar apunte
  editEntryButton.addEventListener("click", function () {
    if (selectedRowIndex !== -1) {
      // Habilitar la edición del apunte seleccionado
      entryForm.reset(); // Limpiar el formulario
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
    }
  });

  // Evento para borrar asiento completo
  deleteAllButton.addEventListener("click", function () {
    tableBody.innerHTML = ""; // Borrar todas las filas
    initialData.length = 0; // Limpiar los datos
    selectedRowIndex = -1; // Resetear el índice seleccionado
    entryForm.reset(); // Limpiar el formulario
  });
});
