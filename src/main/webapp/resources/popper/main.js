$(document).ready(function() {    
	$(document).ready(function() {    
        var ejemplo = $('#example').DataTable({        
            language: {
                    "lengthMenu": "_MENU_ Filas Visibles",
                    "zeroRecords": "No se encontraron resultados",
                    "info": "Total: _TOTAL_ registros",
                    "infoEmpty": "0 registros",
                    "infoFiltered": "(Filtrado de un total de _MAX_ registros)",
                    "sSearch": "Buscar:",
                    "oPaginate": {
                        "sFirst": "Primero",
                        "sLast":"Último",
                        "sNext":">",
                        "sPrevious": "<"
    			     },
    			     "sProcessing":"Procesando...",
                },
            //para usar los botones   
            responsive: "true",
            dom: 'Bfrtilp',       
            buttons:[ 
    			{
    				extend:    'excelHtml5',
    				text:      '<i class="fas fa-file-excel"></i> ',
    				titleAttr: 'Exportar a Excel',
    				className: 'btn btn-success'
    			},
    			{
    				extend:    'pdfHtml5',
    				text:      '<i class="fas fa-file-pdf"></i> ',
    				titleAttr: 'Exportar a PDF',
    				className: 'btn btn-danger'
    			},
    			{
    				extend:    'print',
    				text:      '<i class="fa fa-print"></i> ',
    				titleAttr: 'Imprimir',
    				className: 'btn btn-info'
    			},
    		]	        
        });     
    })
});