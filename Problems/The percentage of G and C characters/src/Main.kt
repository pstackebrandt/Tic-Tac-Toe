fun main() =
        with(getNucleicBases()) {
            println(getGCBasesPercentage(getGCBasesCount(this), this.length))
        }

private fun getNucleicBases() = readLine()!!
        .trim()

private fun getGCBasesCount(nucleicBases: String) = nucleicBases.toLowerCase()
        .count { base -> base in listOf('g', 'c') }

private fun getGCBasesPercentage(gCBasesCount: Int, basesCount: Int) =
        gCBasesCount.toDouble() * 100 / basesCount
