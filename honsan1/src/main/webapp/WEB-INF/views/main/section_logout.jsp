<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<section id="section1">
            <div class="textBox">
                <h2>혼자 무엇을 먹을지 고민이세요?</h2>
                <h3>오늘 어떤 옷을 입어야 할지 날씨때문에 고민이세요?</h3>
                <h4>집을 구하고 싶은데 괜찮은 부동산을 못찾겠나요?</h4>

                <h2>오늘 어떤 옷을 입어야 할지 날씨때문에 고민이세요?</h2>
                <h3>혼자 무엇을 먹을지 고민이세요?</h3>
                <h4>집을 구하고 싶은데 괜찮은 부동산을 못찾겠나요?</h4>

                <h2>집을 구하고 싶은데 괜찮은 부동산을 못찾겠나요?</h2>
                <h3>오늘 어떤 옷을 입어야 할지 날씨때문에 고민이세요?</h3>
                <h4>혼자 무엇을 먹을지 고민이세요?</h4>
            </div>
        </section>

        <section id="section2">
            <article class="article1">
                <div class="contentUp content1">
                    <div class="contentInner"></div>
                </div>
                <div class="contentUp content2">
                    <div class="contentInner"></div>
                </div>
                <div class="contentUp content3">
                    <div class="contentInner"></div>
                </div>
            </article>
            <article class="article2">
                <div class="contentDown content1">
                    <div class="contentInner"></div>
                </div>
                <div class="contentDown content2">
                    <div class="contentInner"></div>
                </div>
                <div class="contentDown content3">
                    <div class="contentInner"></div>
                </div>
            </article>
        </section>
        <form action="${pageContext.request.contextPath}/member/login" method="get">
            <div class="login">
                <button type="button" onclick="sendLogin();">로그인 하러가기</button>
            </div>
        </form>