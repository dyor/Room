plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {

    androidLibrary {
        namespace = "com.example.shared"
        compileSdk = 34
        minSdk = 24

        withAndroidTestOnJvmBuilder {
            compilationName = "unitTest"
            defaultSourceSetName = "androidUnitTest"
        }

        withAndroidTestOnDeviceBuilder {
            compilationName = "instrumentedTest"
            defaultSourceSetName = "androidInstrumentedTest"
            sourceSetTreeName = "test"
        }
    }
    val xcfName = "shared"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
            }
        }

        getByName("androidInstrumentedTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.junit)
            }
        }

        iosMain {
            dependencies {
            }
        }
    }

}