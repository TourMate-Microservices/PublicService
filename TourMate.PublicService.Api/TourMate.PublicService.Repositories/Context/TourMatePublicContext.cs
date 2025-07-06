using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using TourMate.PublicService.Repositories.Models;

namespace TourMate.PublicService.Repositories.Context;

public partial class TourMatePublicContext : DbContext
{
    public TourMatePublicContext()
    {
    }

    public TourMatePublicContext(DbContextOptions<TourMatePublicContext> options)
        : base(options)
    {
    }

    public virtual DbSet<ActiveArea> ActiveAreas { get; set; }

    public virtual DbSet<News> News { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Server=MINEDUCK\\MINEDUCK;Initial Catalog=TourMate_Public;Persist Security Info=False;User ID=sa;Password=12345;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=True;Connection Timeout=30;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<ActiveArea>(entity =>
        {
            entity
                .HasNoKey()
                .ToTable("ActiveArea");

            entity.Property(e => e.AreaContent).HasColumnName("areaContent");
            entity.Property(e => e.AreaId)
                .ValueGeneratedOnAdd()
                .HasColumnName("areaId");
            entity.Property(e => e.AreaName)
                .HasMaxLength(255)
                .HasColumnName("areaName");
            entity.Property(e => e.AreaSubtitle)
                .HasMaxLength(255)
                .HasColumnName("areaSubtitle");
            entity.Property(e => e.AreaTitle)
                .HasMaxLength(255)
                .HasColumnName("areaTitle");
            entity.Property(e => e.AreaType)
                .HasMaxLength(50)
                .HasColumnName("areaType");
            entity.Property(e => e.BannerImg)
                .HasMaxLength(255)
                .HasColumnName("bannerImg");
            entity.Property(e => e.CreatedAt)
                .HasColumnType("datetime")
                .HasColumnName("createdAt");
        });

        modelBuilder.Entity<News>(entity =>
        {
            entity.HasNoKey();

            entity.Property(e => e.BannerImg)
                .HasMaxLength(255)
                .HasColumnName("bannerImg");
            entity.Property(e => e.Category)
                .HasMaxLength(255)
                .HasColumnName("category");
            entity.Property(e => e.Content).HasColumnName("content");
            entity.Property(e => e.CreatedAt)
                .HasColumnType("datetime")
                .HasColumnName("createdAt");
            entity.Property(e => e.NewsId)
                .ValueGeneratedOnAdd()
                .HasColumnName("newsId");
            entity.Property(e => e.Title)
                .HasMaxLength(255)
                .HasColumnName("title");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
