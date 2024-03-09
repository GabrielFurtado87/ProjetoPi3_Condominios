$(document).ready(function () {
    alert("teste");
    
    function carregarInadimplentes() {
        $.ajax({
            url: 'http://localhost:8080/pesqInadimplentes/buscar',
            method: 'GET',
            success: function (data) {
                // Limpando a tabela                
                $('#tabelaInadimplentes tbody').empty();
                //Adicionando todos os dados na tabela                
                for (let i = 0; i < data.length; i++) {
                    let inadimplente = data[i];                   
                    
                    if(inadimplente.situacao == 'inadiplente'){
                        let idInad = $('<td>').text(inadimplente.idApartamentos);
                        let idVaga = $('<td>').text(inadimplente.id_VagaGaragem);
                        let situacao = $('<td>').text(inadimplente.situacao);

                        let tr = $('<tr>').attr('data-idApartamentos', inadimplente.idApartamentos).append(idInad).append(idVaga).append(situacao);
                        $('#tabelaInadimplentes tbody').append(tr);
                    }
                    
                    
                }
            },
            error: function () {
                alert('Não foi possível carregar os agendamentos.');
            }
        });
    }
    carregarInadimplentes();
    
});