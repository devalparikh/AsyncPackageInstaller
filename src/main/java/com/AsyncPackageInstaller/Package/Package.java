package com.AsyncPackageInstaller.Package;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Package {

  public String name;
  public List<Package> dependencies;

  public Package() {
    name = UUID.randomUUID().toString();
    dependencies = new ArrayList<>();
  }

  public Package(String _name) {
    name = _name;
    dependencies = new ArrayList<>();
  }

  public Package(List<Package> _dependencies) {
    name = UUID.randomUUID().toString();
    dependencies = _dependencies;
  }
  public Package(String _name, List<Package> _dependencies) {
    name = _name;
    dependencies = _dependencies;
  }

  public void install() {
    // OS-level install API
    System.out.println("Installing package " + this.name);
  }
}
