package yagatalk.com.service_a.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;
import yagatalk.com.service_a.IpDomain;
import yagatalk.com.service_a.repository.IpRepository;

import java.net.InetAddress;
import java.time.Instant;
import java.util.Optional;

@Service
public class IpService {
    private final IpRepository ipRepository;

    public IpService(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public void increment(String ipAddress) {
        IpDomain ipDomain = ipRepository.findByIpAddress(ipAddress)
                .orElseGet(() -> IpDomain.builder()
                        .ipAddress(ipAddress)
                        .counter(0L)
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .build());
        ipDomain.increment();
        ipRepository.save(ipDomain);
    }

}
