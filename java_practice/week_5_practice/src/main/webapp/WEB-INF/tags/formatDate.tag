<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<%@ attribute name="value" required="true" type="java.util.Date" %>
<%@ tag import="java.text.SimpleDateFormat" %>

<%
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
%>
<%= df.format(value)%>