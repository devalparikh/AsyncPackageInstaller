package com.AsyncPackageInstaller.Package;

import com.AsyncPackageInstaller.Constants.ErrorMessages;

import java.util.List;

public class Util {
  static void validateDependencies(List<Package> dependencies, Class _class) {
    for (Package dependency : dependencies) {
      if (!(dependency.getClass().equals(_class))) {
        throw new RuntimeException(ErrorMessages.MISS_MATCH_DEPENDENCY + ": " + _class.getName());
      }
    }
  }
}
