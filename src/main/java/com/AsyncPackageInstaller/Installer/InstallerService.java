package com.AsyncPackageInstaller.Installer;

import com.AsyncPackageInstaller.Package.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InstallerService {

  private Set<Package> installed = new HashSet<>();

  @Autowired
  public InstallerService() {}

  public List<Package> install(Package p) {
    return installPackageAndDependencies(p);
  }

  // recursive depth first traversal to install dependencies
  private List<Package> installPackageAndDependencies(Package p) {
    if (p == null || installed.contains(p)) return null;

    for (Package dependency : p.dependencies) {
      installPackageAndDependencies(dependency);
    }

    p.install();
    installed.add(p);
    return new ArrayList<>(installed);
  }
}
