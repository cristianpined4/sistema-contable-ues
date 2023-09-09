import LoaderSubCuentas from "../events/LoaderSubCuentas.js";

const Catalogue = [
  {
    action: "DOMContentLoaded",
    event: LoaderSubCuentas,
    element: document,
  },
  {
    action: "DOMContentLoaded",
    event: () => {
      let inputFecha = document.querySelector("input#fecha");
      if (inputFecha) {
        let fecha = new Date();
        let dia = fecha.getDate();
        let mes = fecha.getMonth() + 1;
        let anio = fecha.getFullYear();
        if (dia < 10) {
          dia = "0" + dia;
        }
        if (mes < 10) {
          mes = "0" + mes;
        }
        inputFecha.value = `${anio}-${mes}-${dia}`;
      }
    },
    element: document,
  },
];

export default Catalogue;
