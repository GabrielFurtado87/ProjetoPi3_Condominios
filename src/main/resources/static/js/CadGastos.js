$(document).ready(function () {
    
    //Função para criar agendamentos
    function criarGasto(Gasto) {
        $.ajax({
            url: 'http://localhost:8080/CadGastos/cadastrar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(Gasto),
            success: function () {                
                $('#dataGasto').val('');
                $('#valorGasto').val('');
                $('#descGasto').val(''); 
                alert("Gasto cadastrado com sucesso!")
                carregarSaldoAtual();
            },
            error: function () {
                alert('não foi possível cadastrar o Gasto!');
            }
        });
    }

    $('#formularioCadGastos').submit(function (event) {
        event.preventDefault();              
        let dataGasto = $('#dataGasto').val();
        let utcDate = new Date(dataGasto);
        let dataAjustada = new Date(utcDate.getTime() + utcDate.getTimezoneOffset() * 60000);
        
        let valorGasto = $('#valorGasto').val();
        let descGasto = $('#descGasto').val();
        let gasto = {            
            dataGasto: dataAjustada,
            valorTotal: valorGasto,
            descricao: descGasto
        };
        criarGasto(gasto);
    });
    
    //Função para mostrar o Saldo atual na tela de gastos
    
    function carregarSaldoAtual() {
        $.ajax({
            url: 'http://localhost:8080/PesqGastos/buscar',
            method: 'GET',
            success: function (data) {
                for (let i = 0; i < data.length; i++) {
                    let Gastos = data[i];                   
                    let saldoAtual =  Gastos.saldo;
                    
                    $('#CampoSaldoAtual').text(saldoAtual);
                    
                }
            },
            error: function () {
                alert('Não foi possível carregar os Gastos.');
            }
        });
    }
    
    
    carregarSaldoAtual();
    
    
});