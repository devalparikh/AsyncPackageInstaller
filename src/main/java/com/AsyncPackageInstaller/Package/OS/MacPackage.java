package com.AsyncPackageInstaller.Package.OS;

import com.AsyncPackageInstaller.Package.Package;

import java.util.List;

public class MacPackage extends Package {

  public MacPackage() {
    super();
  }

  public MacPackage(String name) {
    super(name);
  }

  public MacPackage(List<Package> dependencies) {
    super(dependencies);
    Util.validateDependencies(dependencies, this.getClass());
  }

  public MacPackage(String name, List<Package> dependencies) {
    super(name, dependencies);
    Util.validateDependencies(dependencies, this.getClass());
  }

  @Override
  public void install() {
    // OS-level install API
    System.out.println("Installing Mac Package " + this.name);
  }
}
