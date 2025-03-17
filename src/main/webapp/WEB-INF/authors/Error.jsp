<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <sx:head />
        <title>Authors Manager Error</title>
        <link rel="stylesheet" type="text/css" href="../css/common.css">
    </head>

    <body>

        <div class="error_header">
            <h2>Error!</h2>
        </div>

        <hr/>

        <div id="errorDiv">
            <p class="error_paragraph">An unexpected error has occurred while performing the operation that you requested.</>
            <p class="error_paragraph"> Please <a href="<s:url action='listAuthors'/>">try again</a> and if the error persists, please contact an administrator.</p>
        </div>
    </body>
</html>