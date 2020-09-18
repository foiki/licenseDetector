//MIT, BSD-3-Clause and LGPL-3.0 licences do not have no standard headers according to https://spdx.org/licenses

val textFileExtensions = listOf("", "txt", "md")

fun cleanString(string: String): String {
    return string.replace(Regex("\\s"), "")
}

val ApachePart = cleanString("Licensed under the Apache License, Version 2.0 (the \"License\");" +
        "you may not use this file except in compliance with the License." +
        "You may obtain a copy of the License at" +
        "http://www.apache.org/licenses/LICENSE-2.0")

val MITPart = cleanString("Permission is hereby granted, free of charge, to any person obtaining a copy of this" +
        "software and associated documentation files (the \"Software\"), to deal in the Software" +
        "without restriction, including without limitation the rights to use, copy, modify, merge," +
        "publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons" +
        "to whom the Software is furnished to do so, subject to the following conditions:")

val GPL3Part = cleanString("This program is free software: you can redistribute it and/or modify" +
        "it under the terms of the GNU General Public License as published by" +
        "the Free Software Foundation, either version 3 of the License")

val BSD3ClausePart = cleanString("THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\"" +
        "AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES" +
        "OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE" +
        "COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY," +
        "OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;" +
        "LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF" +
        "LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)" +
        "ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.")

val LGPL3Part = cleanString("GNU LESSER GENERAL PUBLIC LICENSE" +
        "Version 3, 29 June 2007" +
        "Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>" +
        "Everyone is permitted to copy and distribute verbatim copies of this license document, but" +
        "changing it is not allowed." +
        "This version of the GNU Lesser General Public License incorporates the terms and conditions" +
        "of version 3 of the GNU General Public License, supplemented by the additional permissions" +
        "listed below.")

val licensesHeadersParts = mapOf(
        Pair(ApachePart, "Apache-2.0"),
        Pair(MITPart, "MIT"),
        Pair(GPL3Part, "GPL-3.0"),
        Pair(BSD3ClausePart, "BSD-3-Clause"),
        Pair(LGPL3Part, "LGPL-3.0"))



