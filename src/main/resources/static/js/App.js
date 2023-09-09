import Auth from "./modules/Auth.js";
import Catalogue from "./modules/Catalogue.js";
import Partidas from "./modules/Partidas.js";

const Modules = [...Auth, ...Catalogue, ...Partidas],
  //urlServer = window.location.origin + "/api";
  urlServer = "http://localhost:8080/api";

Modules.forEach((module) => {
  if (module.element) {
    module.element.addEventListener(module.action, (e) =>
      module.event(urlServer, e)
    );
  }
});
