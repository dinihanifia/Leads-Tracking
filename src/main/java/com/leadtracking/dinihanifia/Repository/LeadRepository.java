package com.leadtracking.dinihanifia.Repository;
import com.leadtracking.dinihanifia.POJO.Model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LeadRepository extends JpaRepository<Lead, UUID> {
    Lead findByEmail(String email);
    Lead findByNomorTelepon(String nomorTelepon);

    @Modifying
    @Query(value = "UPDATE public.lead-tbl SET is_deleted=true WHERE lead_id=1", nativeQuery = true)
    Lead updateIsDeleted(@Param("leadId") UUID leadId);
}
