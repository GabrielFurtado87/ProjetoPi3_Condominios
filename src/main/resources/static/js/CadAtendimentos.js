$(document).ready(function () {
    let idAgendamento;
    function carregarAtendimentos() {
        $.ajax({
            url: 'http://localhost:8080/CadAtendimentos/buscar',
            method: 'GET',
            success: function (data) {
                // Limpando a tabela                
                $('#tabelaAtendimentos tbody').empty();
                //Adicionando os agendamentos na tabela                
                for (let i = 0; i < data.length; i++) {
                    let agendamento = data[i];
                    idAgendamento = agendamento.id;
                    
                    //formatando a data
                    let dataBanco = new Date(agendamento.dataAgendamento);
                    let dataFormatada = ((dataBanco.getDate())) + "/" + ((dataBanco.getMonth() + 1)) + "/" + dataBanco.getFullYear();
                    let dataAgendamento = $('<td>').text(dataFormatada);
                    let idMorador = $('<td>').text(agendamento.idMoradores);


                    let botDelet = $('<button class="btn btn-danger">').text('Excluir')
                            .click(function () {
                                deletarAgendamento($(this).parent().parent().attr('data-id'));
                            });

                    let deletar = $('<td>').append(botDelet);
                    let tr = $('<tr>').attr('data-id', agendamento.id).append(dataAgendamento).append(idMorador).append(deletar);
                    $('#tabelaAtendimentos tbody').append(tr);
                }
            },
            error: function () {
                alert('Não foi possível carregar os agendamentos.');
            }
        });
    }

    //Função para criar agendamentos
    function criarAgendamento(agendamento) {
        $.ajax({
            url: 'http://localhost:8080/CadAtendimentos/cadastrar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(agendamento),
            success: function () {                
                $('#dataCadastro').val('');
                $('#idMorador').val('');
                $('#motivo').val('');
                carregarAtendimentos();
            },
            error: function () {
                alert('não foi possível');
            }
        });
    }

    $('#formularioCriarAgendamento').submit(function (event) {
        event.preventDefault();              
        let dataAgendamento = $('#dataCadastro').val();
        let idMorador = $('#idMorador').val();
        let motivo = $('#motivo').val();

        let Agendamento = {            
            motivo: motivo,
            dataAgendamento: dataAgendamento,
            idMoradores: idMorador
        };
        criarAgendamento(Agendamento);
    });
    
    //função para filtrar a tabela pela data de atendimentos.
    function filtrarAgendamento(dataAgendamento) {
        $.ajax({
            url: 'http://localhost:8080/CadAtendimentos/buscar',
            method: 'GET',
            success: function (data) {
                // Limpando a tabela                
                $('#tabelaAtendimentos tbody').empty();
                //Adicionando os agendamentos na tabela                
                for (let i = 0; i < data.length; i++) {
                    let agendamento = data[i];
                    let dataBanco = new Date(agendamento.dataAgendamento);
                    let dataFormatada = ((dataBanco.getDate())) + "/" + ((dataBanco.getMonth() + 1)) + "/" + dataBanco.getFullYear();
                    if (dataAgendamento === dataFormatada) {
                        let dataAgendamento = $('<td>').text(dataFormatada);
                        let idMorador = $('<td>').text(agendamento.idMoradores);
                        let botDelet = $('<button class="btn btn-danger">').text('Excluir')
                                .click(function () {
                                    deletarAgendamento($(this).parent().parent().attr('data-id'));
                                });

                        let deletar = $('<td>').append(botDelet);
                        let tr = $('<tr>').attr('data-id', agendamento.id).append(dataAgendamento).append(idMorador).append(deletar);
                        $('#tabelaAtendimentos tbody').append(tr);
                    }
                }
            },
            error: function () {
                alert('Não foi possível carregar os agendamentos.');
            }
        });

    }
     $('#formularioFiltro').submit(function (event) {
        event.preventDefault();
        let dataEntrada = $("#dataFiltro").val();
        let dataFiltro = new Date(dataEntrada);
        let dataFiltroFormatado = ((dataFiltro.getDate() + 1)) + "/" + ((dataFiltro.getMonth() + 1)) + "/" + dataFiltro.getFullYear();
        alert(dataFiltroFormatado);
        filtrarAgendamento(dataFiltroFormatado);
    });

    // função para deletar o agendamento
    function deletarAgendamento(id) {
        $.ajax({
            url: 'http://localhost:8080/CadAtendimentos/deletar/' + id,
            method: 'DELETE',
            success: function () {
                alert('Agendamento excluído com sucesso!');
                carregarAtendimentos();
            },
            error: function () {
                alert('Não foi possível excluir o agendamento.');
            }
        });
    }
    carregarAtendimentos();
});