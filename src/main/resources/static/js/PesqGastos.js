$(document).ready(function () {    
    function carregarGastos() {
        $.ajax({
            url: 'http://localhost:8080/PesqGastos/buscar',
            method: 'GET',
            success: function (data) {
                // Limpando a tabela                
                $('#tabelaPesqGastos tbody').empty();
                //Adicionando todos os dados na tabela                
                for (let i = 0; i < data.length; i++) {
                    let Gastos = data[i];                   
                        let idGasto = $('<td>').text(Gastos.id);
                        let valorGasto = $('<td>').text(Gastos.valor_TOTAL);
                        //Tratamento da data
                        let dataBanco = new Date(Gastos.data_GASTO);
                        let dataFormatada = ((dataBanco.getDate())) + "/" + ((dataBanco.getMonth() + 1)) + "/" + dataBanco.getFullYear();
                        let dataGasto = $('<td>').text(dataFormatada);
                       
                        let descrGasto = $('<td>').text(Gastos.descricao);

                        let tr = $('<tr>').attr('data-idApartamentos', Gastos.id).append(idGasto).append(valorGasto).append(dataGasto).append(descrGasto);
                        $('#tabelaPesqGastos tbody').append(tr);
                }
            },
            error: function () {
                alert('Não foi possível carregar os Gastos.');
            }
        });
    }
    //Função para pesquisar os gastos entre datas
    function carregarPorData(inicial , final){            
            $.ajax({
            url: 'http://localhost:8080/PesqGastos/buscar',
            method: 'GET',
            success: function (data) {
                // Limpando a tabela                
                $('#tabelaPesqGastos tbody').empty();
                var dataInicial = new Date(inicial);
                var dataFinal = new Date(final);
                //Adicionando todos os dados na tabela                
                for (let i = 0; i < data.length; i++) {
                        let Gastos = data[i];
                        //Tratamento da data
                        var dataBanco = new Date(Gastos.data_GASTO);
                        let dataFormatada = ((dataBanco.getDate())) + "/" + ((dataBanco.getMonth() + 1)) + "/" + dataBanco.getFullYear();
                        let dataGasto = $('<td>').text(dataFormatada);
                        
                        if(dataBanco >= dataInicial && dataBanco <= dataFinal ){
                            let idGasto = $('<td>').text(Gastos.id);
                            let valorGasto = $('<td>').text(Gastos.valor_TOTAL);
                             let descrGasto = $('<td>').text(Gastos.descricao);
                             let tr = $('<tr>').attr('data-idApartamentos', Gastos.id).append(idGasto).append(valorGasto).append(dataGasto).append(descrGasto);
                        $('#tabelaPesqGastos tbody').append(tr);
                        } else {
                           
                        }
                    }
            },
            error: function () {
                alert('Não foi possível carregar os agendamentos.');
                carregarGastos();
            }
        });
    }
    
    $('#FormularioPesqGastos').submit(function (event) {
        event.preventDefault();  
                
        let inicial = $('#dataInicial').val();
        let final = $('#dataFinal').val();
        
        if(inicial =="" || final == ""){
           alert("Favor inserir as duas datas - Carregando a lista total");
           carregarGastos(); 
        }else{
            carregarPorData(inicial , final);
        }
        
        
        
    });
    
    
    
    
    carregarGastos();
    
});


