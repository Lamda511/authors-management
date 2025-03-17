<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
<head>
    <sx:head />
    <title><s:text name="%{actionName}"/></title>

    <script language="JavaScript" type="text/javascript" src="../js/image-loader.js"></script>

    <link rel="stylesheet" type="text/css" href="../css/author_creation.css">
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
                    <td><p><a href="<s:url action='listAuthors'/>">List Authors</a></p></td>
                </tr>
            </table>
        </div>
     </div>


    <s:set name="pageMode" value="mode"/>
    <s:set var="authorImgSrc" value="%{'No_image.png'}" />
    <s:set var="authorFormActionName" value="%{'addAuthor'}"/>
    <s:set var="authorLanguage" value="%{'en'}"/>
    <s:set var="authorJoinDate" value="%{'today'}"/>
    <s:if test="%{#pageMode=='edit'}">
        <s:set var="authorImgSrc" value="%{imgSrc}"/>
        <s:set var="authorFormActionName" value="%{'updateAuthor'}"/>
        <s:set var="authorLanguage" value="%{language}"/>
        <s:set var="authorJoinDate" value="%{joinedOn}"/>
    </s:if>

    <div id="contentwrap">
      <div id="content">

        <div id="leftcolumnwrap_create">
            <div id="leftcolumn">
                <form id="form1" runat="server">
                    <img id="imgId" src="../images/<s:property value='authorImgSrc'/>" alt="your image" />
                    <br/>
                </form>
            </div>
        </div>

         <s:form action="%{authorFormActionName}" method="post" enctype="multipart/form-data" theme="xhtml">
            <s:hidden name="id" value="%{id}" />
            <s:textfield name="name" label="Name" required="true" cssStyle="width:100%;"/>
            <s:textarea name="biography" label="Full Biography" required="true" cols="65" rows="15"/>
            <s:textarea name="miniBio" label="Brief Biography" cols="65" rows="5"/>
            <sx:autocompleter label="Language" list="languages" name="language" value="%{authorLanguage}" cssStyle="width:100%;"/>
            <sx:datetimepicker name="joinedOn" label="Join Date"
            displayFormat="dd-MMM-yyyy" value="%{authorJoinDate}" cssStyle="width:100%;"/>
            <s:file name="img" onchange="readURL(this)"/>
            <s:hidden name="imgSrc" value="%{imgSrc}" />
         <s:submit/>
         </s:form>

      </div>
   </div>
</div>
</body>

</html>
