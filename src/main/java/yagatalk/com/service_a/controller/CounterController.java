package yagatalk.com.service_a.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yagatalk.com.service_a.service.IpService;

import java.net.InetAddress;

@RestController
@RequestMapping("/api/v1/counter")
@Slf4j
public class CounterController {
    private final IpService ipService;

    public CounterController(IpService ipService) {
        this.ipService = ipService;
    }

    @PatchMapping
    public ResponseEntity<?> incrementCounter(HttpServletRequest request){
       String clientIp = extractClientIp(request);
        ipService.increment(clientIp);
        return ResponseEntity.status(200).body("Ok");
    }

    private String extractClientIp(HttpServletRequest request) {
        String forwardedFor = request.getHeader("X-Forwarded-For");
        if (forwardedFor != null && !forwardedFor.isBlank()) {
            return forwardedFor.split(",")[0]; // если несколько прокси
        }
        return request.getRemoteAddr();
    }
}
