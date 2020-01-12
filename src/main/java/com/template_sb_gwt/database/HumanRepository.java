package com.template_sb_gwt.database;

import com.template_sb_gwt.ui.shared.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
