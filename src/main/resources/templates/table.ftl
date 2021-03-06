<!DOCTYPE html>
<html lang="en">
 
<head>
  <meta charset="UTF-8">
  <title>请求ftl</title>
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/dataTables.bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/jquery.dataTables.min.css" rel="stylesheet" media="screen">
</head>

<body>
  <div class="row-fluid">
    <table id="example" class="display table-striped table-bordered table-hover table-condensed" cellspacing="0" width="100%">
      <thead>
        <tr>
         	<th>rowId</th>
	   		<th>type</th>
	   		<th>clientip</th>
	   		<th>response code</th>
	        <th>message</th>
        </tr>
      </thead>
    </table>
  </div>
  <!-- jQuery -->
  <script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
  <!-- DataTables -->
  <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.js"></script>
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <script src="js/dataTables.bootstrap.min.js"></script>
  
  
  <script type="text/javascript">
  $(document).ready(function() {
	    $('#example').dataTable( {
	        "processing": true,
	        "serverSide": true,
	        "ajax": "tomcatRequestAll",
			"columns": [
				{ "data": "rowId" },
				{ "data": "type" },
				{ "data": "clientip" },
				{ "data": "response" },
				{ "data": "message" },
			]
	    } );
	} );
  </script>
</body>
 
</html>