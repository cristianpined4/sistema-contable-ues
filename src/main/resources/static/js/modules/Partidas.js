import {
  deletePartida,
  getAllPartidas,
  nuevaPartida,
  resetform,
} from "../events/Partidas.js";

const Partidas = [
  {
    action: "click",
    event: resetform,
    element: document.querySelector("#btn-reset"),
  },
  {
    action: "submit",
    event: nuevaPartida,
    element: document.querySelector("#form-partidas"),
  },
  {
    action: "DOMContentLoaded",
    event: getAllPartidas,
    element: document,
  },
  {
    action: "click",
    event: deletePartida,
    element: document,
  },
];

export default Partidas;
