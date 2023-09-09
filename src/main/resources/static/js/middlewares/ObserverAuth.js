import Alert from "../Components/Alert.js";

const ObserverAuth = () => {
  let token = localStorage.getItem("token"),
    user = JSON.parse(localStorage.getItem("user"));

  setInterval(function () {
    token = localStorage.getItem("token");
    user = JSON.parse(localStorage.getItem("user"));

    if (token === null && user === null) {
      clearInterval(this);
    }

    let urlCurrent = window.location.href;
    if (token !== null && user !== null) {
      if (location.pathname == "/" || urlCurrent.includes("index.html")) {
        Alert("success", "Bienvenido/a " + user.usuario_usuario, "success");
        window.location.href = "/dashboard.html";
      }
    } else {
      if (!urlCurrent.includes("index.html")) {
        window.location.href = "index.html";
      }
    }
  }, 1000);

  if (token !== null && user !== null) {
    if (user != null) {
      document.querySelector(
        "h5[data-username]"
      ).innerHTML = `${user.nombre_usuario} ${user.apellido_usuario}`;
    }
  }
};

export default ObserverAuth;
