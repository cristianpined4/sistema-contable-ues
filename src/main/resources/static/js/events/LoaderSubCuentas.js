import Alert from "../Components/Alert.js";

const LoaderSubCuentas = async (url) => {
  let selectCuentas = document.querySelector("select#cuenta");
  if (selectCuentas) {
    try {
      let res = await fetch(url + "/catalogo/subcuentas");
      let json = await res.json();
      let frag = "";
      json.forEach((el) => {
        frag += `<option value="${el.id_subcuentas}">${el.codigo_subcuentas} - ${el.nombre_subcuentas}</option>`;
      });
      selectCuentas.innerHTML += frag;
      $("select#cuenta").selectize({
        sortField: "text",
      });
    } catch (error) {
      Alert("Error", "No se pudieron obtener las cuentas", "error");
    }
  }
};

export default LoaderSubCuentas;
