import Alert from "../Components/Alert.js";

const Login = (url, e) => {
  e.preventDefault();
  const form = e.target;

  if (form.username.value.trim() === "" || form.password.value.trim() === "") {
    Alert("Error", "Todos los campos son obligatorios", "error");
    return;
  }

  const data = new FormData(form);
  const body = JSON.stringify({
    usuario_usuario: data.get("username"),
    contrasena_usuario: data.get("password"),
  }).toString();

  fetch(`${url}/login/auth`, {
    method: "POST",
    body: body,
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) =>
      response.ok ? response.json() : Promise.reject(response)
    )
    .then((response) => {
      if (response.success === true) {
        localStorage.setItem("token", btoa(response.success));
        localStorage.setItem("user", response.user);
        window.location.href = "/dashboard.html";
      } else {
        Alert("Error", "Email o Contraseña Invalidos!", "error");
      }
    })
    .catch((error) => {
      Alert("Error", error, "error");
    });
};

export default Login;
