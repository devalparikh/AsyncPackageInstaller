package com.AsyncPackageInstaller.Installer;

import com.AsyncPackageInstaller.Package.MacPackage;
import com.AsyncPackageInstaller.Package.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// API Layer
@RestController
@RequestMapping(path = "/api/v1/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InstallerController {

    private final InstallerService installerService;

    @Autowired
    public InstallerController(InstallerService installerService) {
        this.installerService = installerService;
    }

    @PostMapping("/install")
    public List<Package> install() {
        Package brew = new MacPackage("brew");
        Package anacondas = new MacPackage("anacondas");
        Package pip = new MacPackage("pip");
        Package cython = new MacPackage("cython");
        Package python = new MacPackage("python", List.of(brew, anacondas, pip, cython));
        Package pytorch = new MacPackage("pytorch", List.of(python));
        return installerService.install(pytorch);
    }

}
