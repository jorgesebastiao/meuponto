package br.com.meuponto.security.token;


import br.com.meuponto.security.config.property.MeuPontoSecutiryProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

    private final MeuPontoSecutiryProperty meuPontoSecutiryProperty;

    public TokenResource(MeuPontoSecutiryProperty meuPontoSecutiryProperty) {
        this.meuPontoSecutiryProperty = meuPontoSecutiryProperty;
    }

    @DeleteMapping("/revoke")
    public void revoke(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(meuPontoSecutiryProperty.getSecurity().isEnableHttps());
        cookie.setPath(req.getContextPath() + meuPontoSecutiryProperty.getSecurity().getOauthPath());
        cookie.setMaxAge(0);

        resp.addCookie(cookie);
        resp.setStatus(HttpStatus.NO_CONTENT.value());
    }

}