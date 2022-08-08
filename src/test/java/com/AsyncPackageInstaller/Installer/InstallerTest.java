package com.AsyncPackageInstaller.Installer;

import com.AsyncPackageInstaller.Constants.ErrorMessages;
import com.AsyncPackageInstaller.Package.OS.MacPackage;
import com.AsyncPackageInstaller.Package.Package;
import com.AsyncPackageInstaller.Package.OS.WindowsPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class InstallerTest {

  @Mock private InstallerService installerServiceMock;

  @InjectMocks private InstallerController installerController;

  Package macPackageDependency1 = new MacPackage();
  Package macPackageDependency2 = new MacPackage(List.of(macPackageDependency1));
  Package macPackageDependency3 = new MacPackage(List.of(macPackageDependency1));
  Package macPackage = new MacPackage(List.of(macPackageDependency2, macPackageDependency3));
  final int numberOfPackages = 4;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    installerController = new InstallerController(installerServiceMock);

    Mockito.when(installerServiceMock.install(any(Package.class)))
        .thenReturn(
            new ArrayList<>(
                List.of(
                    macPackageDependency1,
                    macPackageDependency2,
                    macPackageDependency3,
                    macPackage)));
  }

  @Test
  public void testService() {
    Mockito.doNothing().when(mock(MacPackage.class)).install();
    InstallerService installerService = new InstallerService();

    Package macPackageDependency1 = new MacPackage();
    Package macPackageDependency2 = new MacPackage(List.of(macPackageDependency1));
    Package macPackageDependency3 = new MacPackage(List.of(macPackageDependency1));
    Package macPackage = new MacPackage(List.of(macPackageDependency2, macPackageDependency3));
    int actualPackageCount = 4;

    List<Package> packages = installerService.install(macPackage);
    assertEquals(actualPackageCount, packages.size());
  }

  @Test
  public void testController() {
    List<Package> allPackagesInstalled = installerController.install();
    assertEquals(numberOfPackages, allPackagesInstalled.size());
  }

  @Test
  public void testMissMatchingDependencyMacOSError() {
    Package windowsPackageDependency = new WindowsPackage();

    Exception exception =
        assertThrows(
            RuntimeException.class,
            () -> {
              Package macPackageDependency = new MacPackage(List.of(windowsPackageDependency));
            });

    String expectedMessage =
        ErrorMessages.MISS_MATCH_DEPENDENCY + ": " + MacPackage.class.getName();
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));
  }

  @Test
  public void testMissMatchingDependencyWindowsOSError() {
    Package macPackageDependency = new MacPackage();

    Exception exception =
        assertThrows(
            RuntimeException.class,
            () -> {
              Package windowsPackageDependency = new WindowsPackage(List.of(macPackageDependency));
            });

    String expectedMessage =
        ErrorMessages.MISS_MATCH_DEPENDENCY + ": " + WindowsPackage.class.getName();
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));
  }
}
