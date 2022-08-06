package com.AsyncPackageInstaller.Package;

import com.AsyncPackageInstaller.Constants.ErrorMessages;

import java.util.List;

public class WindowsPackage extends Package {
  public WindowsPackage() {
    super();
  }

  public WindowsPackage(String name) {
    super(name);
  }

  public WindowsPackage(List<Package> dependencies) {
    super(dependencies);
    Util.validateDependencies(dependencies, this.getClass());
  }

  public WindowsPackage(String name, List<Package> dependencies) {
    super(name, dependencies);
    Util.validateDependencies(dependencies, this.getClass());
  }

  @Override
  public void install() {
    System.out.println("Installing Windows Package " + this.name);
  }
}
