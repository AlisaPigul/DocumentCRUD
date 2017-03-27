<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page
        import="java.util.*,com.mycompany.client.*, com.mycompany.rest.*"%>
<%@ page import="com.mycompany.vo.DocumentItemVO" %>
<%@ page import="com.mycompany.vo.DocumentVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>REST WebService Test page</title>
</head>
<body>
<%
    DocumentClientService client = new DocumentClientService();
%>
<p>
    Get all documents: <br>

        <%
			List<DocumentVO> documents = client.testGetAll();
		%>

    All documents :	<%=documents.size()%><br>
<p>
    Create documents: <br>

        <%
			DocumentVO document = client.testCreation();
			DocumentVO document2 = client.testCreation();
		%>

    Create document :	<%=document.toString()%><br>
    Create document 2 :	<%=document2.toString()%><br>
<p>
    Update document: <br>

        <%
			DocumentVO document3 = client.testUpdate(document.getId());
		%>

    Update document :	<%=document3.toString()%><br>
<p>
    Get all documents: <br>

        <%
			documents = client.testGetAll();
		%>

    All documents :	<%=documents.size()%><br>
        <%
			for (DocumentVO doc : documents) {
		%>
        <%=doc.toString()%><br>
        <%
			}
		%>
<p>
    Delete document 2: <br>

        <%
			client.testDelete(document2.getId());
			documents = client.testGetAll();
		%>

    All documents :	<%=documents.size()%><br>
        <%
			for (DocumentVO doc : documents) {
		%>
        <%=doc.toString()%><br>
        <%
			}
		%>
</body>
</html>