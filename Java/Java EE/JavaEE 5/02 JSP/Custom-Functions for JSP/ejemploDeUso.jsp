

                <%-- Valor a declarar --%>
                <c:if test="${rf:esVacio(bienInmueble.valorExento)==false}">
                  <p>
                    <spring:message code="714.2017.editarBienesInmuebles.valorDeclarar" />
                    <c:out value=":" />
                    <strong><zb:importe value="${bienInmueble.valorDeclarar}" /></strong>
                  </p>
                </c:if>