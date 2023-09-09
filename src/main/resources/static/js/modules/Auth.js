import ButtonMenu from "../events/ButtonMenu.js";
import Login from "../events/Login.js";
import logout from "../events/logout.js";
import ObserverAuth from "../middlewares/ObserverAuth.js";

const Auth = [
  {
    action: "submit",
    event: Login,
    element: document.querySelector("#login-form"),
  },
  {
    action: "click",
    event: logout,
    element: document.querySelector("[data-logout]"),
  },
  {
    action: "click",
    event: ButtonMenu,
    element: document.querySelector("button.navbar-toggler"),
  },
  {
    action: "click",
    event: ButtonMenu,
    element: document.querySelector("div.sidebar .menu"),
  },
  {
    action: "DOMContentLoaded",
    event: ObserverAuth,
    element: document,
  },
];

export default Auth;
