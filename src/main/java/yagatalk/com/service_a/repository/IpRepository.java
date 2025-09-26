package yagatalk.com.service_a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yagatalk.com.service_a.IpDomain;

import java.net.InetAddress;
import java.util.Optional;

public interface IpRepository extends JpaRepository<IpDomain,String> {
    Optional<IpDomain> findByIpAddress(String ipAddress);
}
