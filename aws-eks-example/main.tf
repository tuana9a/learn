resource "aws_eks_cluster" "zero" {
  name     = "zero"
  role_arn = aws_iam_role.eks_cluster_role.arn
  version  = "1.28"

  vpc_config {
    subnet_ids = [
      aws_subnet.one.id,
      aws_subnet.two.id,
      aws_subnet.three.id,
    ]
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Cluster handling.
  # Otherwise, EKS will not be able to properly delete EKS managed EC2 infrastructure such as Security Groups.
  depends_on = [
    aws_iam_role_policy_attachment.eks_cluster_role_policy_attachment_1,
  ]
}

resource "aws_eks_addon" "vpccni_zero" {
  cluster_name  = aws_eks_cluster.zero.name
  addon_name    = "vpc-cni"
  addon_version = "v1.14.1-eksbuild.1"

  configuration_values = jsonencode({
    env = {
      # TODO: the bellow configs have interesting story to tell.
      WARM_IP_TARGET : "3",
      MINIMUM_IP_TARGET : "3",
    }
  })

  resolve_conflicts_on_update = "OVERWRITE" # TODO: OVERWRITE vs PRESERVE
}

resource "aws_eks_addon" "coredns_zero" {
  cluster_name  = aws_eks_cluster.zero.name
  addon_name    = "coredns"
  addon_version = "v1.10.1-eksbuild.2"

  resolve_conflicts_on_update = "OVERWRITE"
}

resource "aws_eks_addon" "kubeproxy_zero" {
  cluster_name  = aws_eks_cluster.zero.name
  addon_name    = "kube-proxy"
  addon_version = "v1.28.1-eksbuild.1"

  resolve_conflicts_on_update = "OVERWRITE"
}

resource "aws_eks_node_group" "zero" {
  cluster_name    = aws_eks_cluster.zero.name
  node_group_name = "zero"
  node_role_arn   = aws_iam_role.eks_node_role.arn
  subnet_ids = [
    aws_subnet.one.id,
    aws_subnet.two.id,
    aws_subnet.three.id,
  ]
  capacity_type = "SPOT"

  scaling_config {
    desired_size = 1
    max_size     = 3
    min_size     = 1
  }

  update_config {
    max_unavailable = 1
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Node Group handling.
  # Otherwise, EKS will not be able to properly delete EC2 Instances and Elastic Network Interfaces.
  depends_on = [
    aws_iam_role_policy_attachment.eks_node_role_policy_attachment_1,
    aws_iam_role_policy_attachment.eks_node_role_policy_attachment_2,
    aws_iam_role_policy_attachment.eks_node_role_policy_attachment_3,
    aws_iam_role_policy_attachment.eks_node_role_policy_attachment_4,
  ]
}

output "eks-name" {
  value = aws_eks_cluster.zero.name
}

output "eks-endpoint" {
  value = aws_eks_cluster.zero.endpoint
}

output "eks-version" {
  value = aws_eks_cluster.zero.version
}

output "eks-update-kubeconfig-command" {
  value = "aws eks update-kubeconfig --name ${aws_eks_cluster.zero.name}"
}

resource "local_file" "private_key" {
  content  = templatefile("templates/cluster-autoscaler-autodiscover.yaml.tftpl", { cluster_name = aws_eks_cluster.zero.name })
  filename = "tmp/cluster-autoscaler-autodiscover.yaml"
}
