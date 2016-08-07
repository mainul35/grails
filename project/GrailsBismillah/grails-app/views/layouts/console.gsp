<!DOCTYPE html>
<html>
<head>
	<g:render template="/layouts/includeFiles"/>
	<style>
	body{
		background-color: #000000;
		margin: 0;
		font-family: monospace;
	}
	</style>
</head>
<body>

<g:render template="/layouts/header"/>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<g:layoutBody/>
		</div>
	</div>
</div>
</body>
</html>