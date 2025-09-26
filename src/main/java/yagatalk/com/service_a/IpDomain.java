package yagatalk.com.service_a;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.net.InetAddress;
import java.time.Instant;

@Entity
@Table(name = "ip_counter")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IpDomain {
    @Id
    @Column(name = "ip_address",nullable = false,unique = true)
    private String ipAddress;

    @Column(name = "counter")
    private Long counter;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public Long increment(){
        updatedAt = Instant.now();
        counter++;
        return counter;
    }
}
