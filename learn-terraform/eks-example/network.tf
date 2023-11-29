resource "aws_vpc" "zero" {
  cidr_block = "10.0.0.0/16"
  tags = {
    Name = "eks-example zero"
  }
}

resource "aws_subnet" "one" {
  vpc_id            = aws_vpc.zero.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = data.aws_availability_zones.available.names[0]

  map_public_ip_on_launch = true

  tags = {
    Name = "eks-example one"
  }
}

resource "aws_subnet" "two" {
  vpc_id            = aws_vpc.zero.id
  cidr_block        = "10.0.2.0/24"
  availability_zone = data.aws_availability_zones.available.names[1]

  map_public_ip_on_launch = true

  tags = {
    Name = "eks-example two"
  }
}

resource "aws_subnet" "three" {
  vpc_id            = aws_vpc.zero.id
  cidr_block        = "10.0.3.0/24"
  availability_zone = data.aws_availability_zones.available.names[2]

  map_public_ip_on_launch = true

  tags = {
    Name = "eks-example three"
  }
}

resource "aws_internet_gateway" "public_access" {
  vpc_id = aws_vpc.zero.id
}

resource "aws_route" "public_access" {
  route_table_id         = aws_vpc.zero.default_route_table_id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.public_access.id
}

resource "aws_security_group" "allow_everything" {
  vpc_id      = aws_vpc.zero.id
  name        = "allow-everything"
  description = "Allow everything"

  ingress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
