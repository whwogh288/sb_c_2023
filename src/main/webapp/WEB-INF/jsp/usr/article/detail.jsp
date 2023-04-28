<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <div class="table-box-type-1">
      <table>
        <colgroup>
          <col width="300" />
          <col width="600" />
        </colgroup>
        <tbody>
          <tr>
            <th>번호</th>
            <td>${article.id}</td>

          </tr>
          <tr>

            <th>제목</th>
            <td>${article.title}</td>

          </tr>
          <tr>

            <th>내용</th>
            <td>${article.body}</td>

          </tr>
          <tr>

            <th>작성날짜</th>
            <td>${article.regDate.substring(2, 16)}</td>

          </tr>
          <tr>

            <th>수정날짜</th>
            <td>${article.updateDate.substring(2, 16)}</td>

          </tr>
          <tr>

            <th>작성자</th>
            <td>${article.extra_writerName}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="btns">
      <button type="button" onclick="history.back();">뒤로가기</button>
      <a class="btn-text-link" href="../article/doModify?id=${article.id}">수정</a>
      <c:if test="${article.extra_actorCanDelete}">
        <a class="btn-text-link" onclick="if ( confirm('정말 삭제하시겠습니까?') == false ) return false;"
          href="../article/doDelete?id=${article.id}">삭제</a>
      </c:if>
    </div>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>