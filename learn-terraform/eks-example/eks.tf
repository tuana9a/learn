resource "aws_eks_cluster" "cluster_1" {
  name     = "cluster_1"
  role_arn = aws_iam_role.eks_cluster_role.arn

  vpc_config {
    subnet_ids = [aws_subnet.subnet_1.id, aws_subnet.subnet_2.id, aws_subnet.subnet_3.id]
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Cluster handling.
  # Otherwise, EKS will not be able to properly delete EKS managed EC2 infrastructure such as Security Groups.
  depends_on = [
    aws_iam_role_policy_attachment.attach_policy_to_eks_cluster_role
  ]
}

output "endpoint" {
  value = aws_eks_cluster.cluster_1.endpoint
}

output "kubeconfig-certificate-authority-data" {
  value = aws_eks_cluster.cluster_1.certificate_authority[0].data
}

resource "aws_eks_node_group" "node_group_1" {
  cluster_name    = aws_eks_cluster.cluster_1.name
  node_group_name = "node_group_1"
  node_role_arn   = aws_iam_role.eks_node_role.arn
  subnet_ids      = [aws_subnet.subnet_1.id, aws_subnet.subnet_2.id, aws_subnet.subnet_3.id]

  scaling_config {
    desired_size = 2
    max_size     = 3
    min_size     = 1
  }

  update_config {
    max_unavailable = 1
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Node Group handling.
  # Otherwise, EKS will not be able to properly delete EC2 Instances and Elastic Network Interfaces.
  depends_on = [
    aws_iam_role_policy_attachment.attach_policy_to_eks_node_role_1,
    aws_iam_role_policy_attachment.attach_policy_to_eks_node_role_2,
    aws_iam_role_policy_attachment.attach_policy_to_eks_node_role_3,
  ]
}