export const renderDataDashdboard = async (urlServer, e) =>{
    if(document.querySelector("#data-dashboard")){
        let res = await fetch(`${urlServer}/login/count`)
        let json = await res.json();
        document.querySelector("#numUsers").innerHTML=`Total Usuários: ${json.data}`;

        res = await fetch(`${urlServer}/partidas/`)
        json = await res.json()
        json = JSON.parse(json.data)
        document.querySelector("#numPartidas").innerHTML= `Total de Partidas: ${json.length}`;
    }
}