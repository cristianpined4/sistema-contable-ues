import { searchLibroMayor } from "../events/LibroMayor.js";

const LibroMayor = [
  {
    action: "submit",
    event: searchLibroMayor,
    element: document.querySelector("#form-libro-mayor"),
  },
];

export default LibroMayor;
