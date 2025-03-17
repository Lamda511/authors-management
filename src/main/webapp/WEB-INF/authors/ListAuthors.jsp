<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<title>Authors</title>

<html>
<head>
    <title><s:text name="ActionName.ListAuthors"/></title>

    <link rel="stylesheet" type="text/css" href="../css/author_listing.css">
    <link rel="stylesheet" type="text/css" href="../css/layout.css">
</head>

<body>

<div id="wrapper">
    <div id="#headerwrap">
        <div id="header">
            <s:property value="actionName"/>
        </div>
    </div>

    <div id="navigationwrap">
        <div id="navigation">
            <table>
                <tr>
                    <td><p><a href="<s:url action='createAuthorFormPage'/>">Create Author</a></p></td>
                    <td><p><a href="<s:url action='listAuthors'/>">Refresh Authors</a></p></td>
                </tr>
            </table>
        </div>
    </div>

    <div id="contentwrap">
    <s:iterator value="authorsList">
        <div id="content">
            <div id="leftcolumnwrap">
                <div id="leftcolumn">
                    <img id="authorImg" src="../images/<s:property value='imgSrc'/>" alt="" />
                </div>
            </div>

            <table>
                <tr>
                    <td>Name:</td>
                    <td><p><s:property value="name"/></p></td>
                </tr>
                <tr>
                    <td>Short Biography:</td>
                    <td><p><s:property value="miniBio"/></p></td>
                </tr>
                <tr>
                    <td>Full Biography:</td>
                    <td><p><s:property value="biography"/></p></td>
                </tr>
                <tr>
                    <td>Language:</td>
                    <td><p><s:property value="language"/></p></td>
                </tr>
                <tr>
                    <td>Join Date:</td>
                    <td><p><s:property value="joinedOn"/></p></td>
                </tr>
                <tr>
                    <td>
                        <s:form action="editAuthorFormPage" cssStyle="width:100%;">
                        <s:hidden name="id" value="%{id}" />
                        <s:hidden name="originalName" value="%{name}"/>
                        <s:submit  value="Edit" type="button"/>
                        </s:form>
                    </td>
                <tr>
            </table>
         </div>
      </s:iterator>
    </div>

    <div id="navigationwrap">
        <div id="navigation">
            <table>
                <tr>
                    <td><p><a href="<s:url action='createAuthorFormPage'/>">Create Author</a></p></td>
                    <td><p><a href="<s:url action='listAuthors'/>">Refresh Authors</a></p></td>
                </tr>
            </table>
        </div>
    </div>

  </div>
</body>
</html>
