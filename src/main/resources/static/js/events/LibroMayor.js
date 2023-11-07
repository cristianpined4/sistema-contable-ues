import Alert from "../Components/Alert.js";

const render = (data) => {
  const content = document.querySelector("#libro-mayor-table");
  content.innerHTML = "";

  if (data.length == 0) {
    content.innerHTML = `<div class="alert alert-danger" role="alert">
    <h3 class="alert-heading">Error</h3>
    No se encontraron resultados para el rango de fechas seleccionado,
    intente con otro rango de fechas.
  </div>`;
    return;
  }

  const clearDuplicador = (arr) => {
    const titulos = new Set();
    return arr.reduce((resultado, item) => {
      if (!titulos.has(item[0])) {
        titulos.add(item[0]);
        resultado.push(`${item[3]} - ${item[0]}`);
      }
      return resultado;
    }, []);
  };

  const arregloSinRepetidos = clearDuplicador(data);

  arregloSinRepetidos.forEach((item) => {
    const table = document.createElement("table"),
      thead = document.createElement("thead"),
      tbody = document.createElement("tbody"),
      div = document.createElement("div");

    div.classList.add("col-md-4");

    table.classList.add("table", "border-0", "table-hover", "mt-3", "col-md-4");

    thead.style.borderBottom = "3px solid";

    thead.innerHTML = `<tr>
      <th colspan="2" class="text-center"><strong>${item}</strong></th>
    </tr>`;
    let haber = [],
      debe = [],      
      rubro = "";

    data.forEach((item2) => {
      if (item === `${item2[3]} - ${item2[0]}`) {
        rubro = item2[4];
        if (item2[1] === "HABER") {
          haber.push(item2[2]);
        } else {
          debe.push(item2[2]);
        }
      }
    });

    haber = Array.from(new Set(haber));
    debe = Array.from(new Set(debe));

    let contadorHaber = 0,
      contadorDebe = 0;

    for (let i = 0; i < Math.max(debe.length, haber.length); i++) {
      let tr = document.createElement("tr");
      contadorDebe += debe[i] ? parseFloat(debe[i]) : 0;
      contadorHaber += haber[i] ? parseFloat(haber[i]) : 0;

      tr.innerHTML = `
        <td style="width:50%;border-right: 3px solid;">${
          debe[i] ? "$"+ debe[i].toFixed(2) : ""
        }</td>
        <td style="width:50%">${haber[i] ? "$"+ haber[i].toFixed(2) : ""}</td>
      `;
      tbody.appendChild(tr);
    }

    let tr1 = document.createElement("tr");

    tr1.style.borderTop = "3px solid";

    tr1.innerHTML = `
      <td style="border-right: 3px solid"><strong>${
      contadorDebe != 0 ?  "$"+ contadorDebe.toFixed(2) : ""
    }</strong></td>
      <td><strong>${
      contadorHaber != 0 ?  "$"+ contadorHaber.toFixed(2) : ""
    }</strong></td>
    `;


    let tr = document.createElement("tr"),
    cuentasDeudoras = ["ACTIVO","EGRESOS"];

   if(cuentasDeudoras.includes(rubro)){
      contadorDebe = contadorDebe - contadorHaber;
      contadorHaber = 0;
   }else {
    contadorHaber = contadorHaber - contadorDebe;
    contadorDebe = 0;
   }

    tr.style.borderTop = "3px solid";

    if(cuentasDeudoras.includes(rubro)){
      tr.innerHTML = `
        <td colspan="2"><strong style="${contadorDebe < 0 ? "color:red": ""};display:flex;justify-content:space-around">${
        contadorDebe != 0 ?  "<span>Saldo Deudor:</span> $"+ contadorDebe.toFixed(2) : ""
      }</strong></td>
      `;
    }else {
      tr.innerHTML = `
      <td colspan="2"><strong style="${contadorHaber < 0 ? "color:red": ""};display:flex;justify-content:space-around">${
        contadorHaber != 0 ?  "<span>Saldo Acreedor:</span> $"+ contadorHaber.toFixed(2) : ""
      }</strong></td>
      `;
    }

    if (contadorDebe ==  0 && contadorHaber == 0) {
      tr.style.borderBottom = "3px solid";
      tr.style.borderBottomStyle = "double";
    }

    tbody.appendChild(tr1);
    tbody.appendChild(tr);
    table.appendChild(thead);
    table.appendChild(tbody);
    div.appendChild(table);
    content.appendChild(div);
  });
};

export const searchLibroMayor = (urlServer, e) => {
  e.preventDefault();
  let inicio = e.target.inicio ? e.target.inicio.value : null,
    fin = e.target.fin ? e.target.fin.value : null;
  if (!inicio || !fin) {
    Alert("Error", "Debe ingresar un rango de fechas", "error");
    return;
  }

  fetch(`${urlServer}/libro-mayor/search/${inicio}/${fin}`)
    .then((res) => (res.ok ? res.json() : Promise.reject(res)))
    .then((data) => {
      if (data.success) {
        render(JSON.parse(data.data));
      } else {
        Alert("Error", "No se pudo obtener el libro mayor", "error");
      }
    })
    .catch((err) => {
      console.log(err);
      Alert("Error", "No se pudo obtener el libro mayor", "error");
    });
};
