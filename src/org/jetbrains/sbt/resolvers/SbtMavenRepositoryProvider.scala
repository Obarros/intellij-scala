package org.jetbrains.sbt.resolvers

import java.util

import com.intellij.openapi.project.Project
import org.jetbrains.idea.maven.indices.{MavenIndex, MavenRepositoryProvider}
import org.jetbrains.idea.maven.model.MavenRemoteRepository

class SbtMavenRepositoryProvider extends MavenRepositoryProvider {
  import scala.collection.JavaConverters._
  override def getRemoteRepositories(project: Project): util.Set[MavenRemoteRepository] = {
    val result = SbtResolverUtils.getProjectResolvers(project).collect {
      case SbtResolver(kind, name, root) if kind == SbtResolver.Kind.Maven =>
        new MavenRemoteRepository(name, null, MavenIndex.normalizePathOrUrl(root), null, null, null)
    }.toSet
    result.asJava
  }
}