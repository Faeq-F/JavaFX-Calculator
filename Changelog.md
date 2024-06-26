# Changelog

All notable changes to this project will be documented in this file.

## [Release 5.0] - 2023-12-07

### Added

- History pane to [GUI].

### Fixed

- Nothing.

### Changed

- [GUI] to be simpler.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- [GUI] buttons for different notation types.
    - The buttons have been combined into a single toggle button.
- [GUI] text field for answer text.
    - The answer text will now share the input text field. The input can be viewed with the answer in the history pane.

## [Release 4.0] - 2023-12-06

### Added

- History option to [CLI].

### Fixed

- Nothing.

### Changed

- [CLI] menu to be simpler.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- [CLI] menu options for calculate expression, switch to Standard calculator and switch to Reverse Polish Calculator.
    - Calculate expression option is now combined with the set expression option.
    - Switching calculators is now combined into a single 'change notation type' option.

## [Release 3.1] - 2023-12-06

### Added

- Nothing.

### Fixed

- Nothing.

### Changed

- Error messages to be more specific.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 3.0] - 2023-12-05

### Added

- Standard ([infix]) calculator.

### Fixed

- Nothing.

### Changed

- Integrated [infix] calculator with [GUI] & [CLI] views.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 2.1] - 2023-11-30

### Added

- Factory for views.

### Fixed

- Implementation of observer methods.

### Changed

- Made AsciiView ([CLI]) a singleton.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 2.0] - 2023-11-28

### Added

- Reverse Polish ([postfix]) calculator.

### Fixed

- Nothing.

### Changed

- Integrated [postfix] calculator with [GUI] & [CLI] views.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 1.0] - 2023-11-23

### Added

- Interfaces for user interactions with the calculator.
    - AsciiView - interactions through the [command line interface].
    - CalcView - interactions through the [graphical interface].

### Fixed

- The namespace of View.fxml & application.css for the GUI.

### Changed

- Namespaces for classes that make up the user interfaces.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 0.1] - 2023-11-22

### Added

- Nothing.

### Fixed

- Nothing.

### Changed

- Updated JavaDoc for all classes.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

## [Release 0.0] - 2023-11-08

### Added

- [Stack assembly].
     - Forms the central mechanism of the calculator.

### Fixed

- Nothing.

### Changed

- Namespaces for classes that make up the stack assembly.

### Security

- No changes.

### Deprecated

- Nothing.

### Removed

- Nothing.

[Release 5.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-5.0
[Release 4.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-4.0
[Release 3.1]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-3.1
[Release 3.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-3.0
[infix]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-infixCalculator?ref_type=heads
[Release 2.1]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-2.1
[command line interface]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-cli?ref_type=heads
[Release 2.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-2.0
[CLI]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-cli?ref_type=heads
[GUI]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-gui?ref_type=heads
[postfix]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-postfixCalculator?ref_type=heads
[release 1.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-1.0
[graphical interface]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-gui?ref_type=heads
[release 0.1]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-0.1
[release 0.0]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/release-0.0
[Stack assembly]: https://gitlab.cim.rhul.ac.uk/zlac318/CS2800/-/tree/feature-stackAssembly?ref_type=heads