package hello.login.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return "세션이 없습니다.";
        }

        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name = {}. values = {}", name, session.getAttribute(name)));

        log.info("session id = {}", session.getId());
        log.info("getMaxInactiveInterval = {}", session.getMaxInactiveInterval());
        log.info("creationTime = {}", session.getCreationTime());
        log.info("lastAccessTime = {}", session.getLastAccessedTime());
        log.info("isNew = {}", session.isNew());

        return "세션 출력";
    }
}
