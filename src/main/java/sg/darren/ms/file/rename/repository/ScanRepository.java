package sg.darren.ms.file.rename.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.darren.ms.file.rename.model.entity.ScanEntity;

public interface ScanRepository extends JpaRepository<ScanEntity, Long> {

}
