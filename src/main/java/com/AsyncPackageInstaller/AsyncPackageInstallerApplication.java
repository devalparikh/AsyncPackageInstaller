package com.AsyncPackageInstaller;

// import com.AsyncPackageInstaller.Installer.Installer;
import com.AsyncPackageInstaller.Package.MacPackage;
import com.AsyncPackageInstaller.Package.Package;
import com.AsyncPackageInstaller.Package.WindowsPackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AsyncPackageInstallerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AsyncPackageInstallerApplication.class, args);
  }
}
