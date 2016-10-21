<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="path" required="true"%>
<c:url value="/resources/" var="resourcePath" />
<script src="${resourcePath}${path}"></script>